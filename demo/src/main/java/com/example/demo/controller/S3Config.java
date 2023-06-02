package com.example.demo.controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

  private String s3ClientRegion = "ap-northeast-1";
  private String accessKey = "dummy";
  private String secretKey = "dummy";
  private String endpoint = "http://localhost:4566";

  @Bean
  public AmazonS3 s3Client() {
    AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
    return AmazonS3ClientBuilder
        .standard()
        .withEndpointConfiguration(new EndpointConfiguration(endpoint, s3ClientRegion))
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .withPathStyleAccessEnabled(true)
        .build();
  }
}
