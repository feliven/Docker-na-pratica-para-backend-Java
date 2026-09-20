package br.com.alura.produto.infra.config;

import org.junit.jupiter.api.Test;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;

import java.net.URI;

public class S3Test {

    @Test
    void testS3WithHyphenAndPathStyle() {
        S3Client client = S3Client.builder()
                .endpointOverride(URI.create("http://simulador-aws:4566"))
                .region(Region.of("us-east-1"))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("test", "test")))
                .serviceConfiguration(S3Configuration.builder()
                        .pathStyleAccessEnabled(true)
                        .build())
                .build();

        try {
            client.headBucket(HeadBucketRequest.builder().bucket("local-bucket").build());
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getClass().getName() + " - " + e.getMessage());
        }
    }

    @Test
    void testS3WithHyphenWithoutPathStyle() {
        S3Client client = S3Client.builder()
                .endpointOverride(URI.create("http://simulador-aws:4566"))
                .region(Region.of("us-east-1"))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("test", "test")))
                .serviceConfiguration(S3Configuration.builder()
                        .build())
                .build();

        try {
            client.headBucket(HeadBucketRequest.builder().bucket("local-bucket").build());
        } catch (Exception e) {
            System.out.println("EXCEPTION WITHOUT PATH STYLE: " + e.getClass().getName() + " - " + e.getMessage());
        }
    }
}
