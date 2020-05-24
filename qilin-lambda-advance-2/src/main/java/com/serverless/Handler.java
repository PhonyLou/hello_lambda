package com.serverless;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;


public class Handler implements RequestHandler<SNSEvent, Object> {
	public Object handleRequest(SNSEvent request, Context context){

		if (null != request.getRecords().get(0).getSNS().getMessage()) {

			AWSLambda awsLambda = AWSLambdaClientBuilder.defaultClient();
			InvokeRequest invokeRequest = new InvokeRequest();
			invokeRequest.setFunctionName("arn:aws:lambda:ap-southeast-1:494526681395:function:qilin-lambda-basic-5-dev-currentTime");
			awsLambda.invoke(invokeRequest);
		}


		return null;
	}
}
