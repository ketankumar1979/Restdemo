package extraResource;

public class Payload {
    public static String getData() {
        String s = "{\\n\" +\n" +
                "                \"    \\\"name\\\": \\\"morpheus\\\",\\n\" +\n" +
                "                \"    \\\"job\\\": \\\"leader\\\"\\n\" +\n" +
                "                \"}";
        return s;
    }

    public static String postData() {
        String s = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        return s;

    }

    public static String putData() {
        String s = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        return s;
    }

    public static String googleApipost() {
        String s = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
        return s;

    }
}

//ketan
    
    //patel

