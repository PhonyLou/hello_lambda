package com.serverless;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: " + input);
		AWSLambda awsLambda = AWSLambdaClientBuilder.defaultClient();

		InvokeRequest invokeRequest = new InvokeRequest();
		invokeRequest.setFunctionName("arn:aws:lambda:ap-southeast-1:494526681395:function:qilin-lambda-basic-4-dev-currentTime");
		InvokeResult invokeResult = awsLambda.invoke(invokeRequest);


		Response responseBody = new Response("Hello, the copyObjectResult.getExpirationTime is " + invokeResult.getPayload());
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
