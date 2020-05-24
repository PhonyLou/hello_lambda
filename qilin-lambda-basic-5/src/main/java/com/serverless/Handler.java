package com.serverless;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CopyObjectResult;
import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: " + input);
		AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
		CopyObjectResult copyObjectResult = s3Client.copyObject("qilin-lambda-basic-4-bucket", "qilin-lambda-basic-4-bucket.txt",
				"qilin-lambda-basic-5-bucket", "qilin-lambda-basic-5-bucket.txt");


		Response responseBody = new Response("Hello, the copyObjectResult.getExpirationTime is " + copyObjectResult.getExpirationTime());
		Map<String, String> headers = new HashMap<>();
		headers.put("X-Powered-By", "AWS Lambda & Serverless");
		headers.put("Content-Type", "application/json");
		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(responseBody)
				.setHeaders(headers)
				.build();
	}
}
