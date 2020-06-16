### Set up

Config aws credential by using
```shell script
$ aws configure
```

### Basic 1

Skip

### Basic 2 - Create lambda function via aws cli with ZIP file and invoke

```
$ cd qilin-lambda-basic-2

$ aws lambda create-function --function-name function-qilin-cli \
--zip-file fileb://function-qilin-cli.zip --handler index.handler --runtime nodejs12.x \
--role arn:aws:iam::494526681395:role/for-aws-training-2
```

Invoke
```
$ aws lambda invoke --function-name function-qilin-cli out --log-type Tail
```

### Basic 4 - Access s3 bucket and read file from s3 bucket
### Proficient 1

```shell script
$ cd qilin-lambda-basic-4-proficient-1
$ mvn package
$ sls deploy
$ serverless invoke --function currentTime --log

# Proficient 1
$ curl https://w4rin5c5lb.execute-api.ap-southeast-1.amazonaws.com/dev/ping
```

### Basic 5 - Copy file from a s3 bucket to another s3 bucket

```shell script
$ cd qilin-lambda-basic-5
$ mvn package
$ sls deploy

$ serverless invoke --function currentTime --log
```

### Advanced 1 - AWS lambda invoke another one

```shell script
$ cd qilin-lambda-advance-1
$ mvn package
$ sls deploy
$ serverless invoke --function currentTime --log
```

### Advanced 2 - AWS lambda can consumer event from SNS

```shell script
$ cd qilin-lambda-advance-2
$ mvn package
$ sls deploy
$ serverless invoke --function currentTime --log
```

### Advanced 3 - Cloudwatch trigger lambda to read file regularly

create a rule in cloudwatch, and trigger Lambda regularly



