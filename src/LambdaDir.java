package test;

import jdk.management.resource.ResourceId;

/**
 * Created by oleg on 7/20/16
 */
public class LambdaDir {

    public static void main(String[] args) {
        System.setProperty("jdk.internal.lambda.dumpProxyClasses" ,"//home//oleg//lambda");
        ResourceId resourceId = () -> "resourses/test";
        System.out.println(resourceId.getName());
    }


}