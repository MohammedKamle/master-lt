package AppAutomation;

import org.json.JSONObject;

public class ReadTestID {

    public static void main(String[] args) {
        String jsonString = "{\"data\":{\"test_id\":\"Z17EF-OPUKH-BDAE8-YEPXU\",\"build_id\":1,\"name\":\"mytest\",\"user_id\":250563,\"username\":\"bahubali\",\"duration\":0,\"platform\":\"win10\",\"browser\":\"chrome\",\"browser_version\":\"71.0\",\"device\":\"string\",\"status_ind\":\"string\",\"session_id\":\"bc02fd99593f14e37850745d66197f89\",\"build_name\":\"my-build\",\"create_timestamp\":\"2019-02-05 08:24:36\",\"start_timestamp\":\"2019-02-05 08:24:58\",\"end_timestamp\":\"2019-02-05 08:27:22\",\"remark\":\"completed\",\"console_logs_url\":\"https://api.lambdatest.com/automation/api/v1/sessions/bc02fd99593f14e37850745d66197f89/log/console\",\"network_logs_url\":\"https://api.lambdatest.com/automation/api/v1/sessions/bc02fd99593f14e37850745d66197f89/log/network\",\"command_logs_url\":\"http://api.lambdatest.com/automation/api/v1/sessions/bc02fd99593f14e37850745d66197f89/log/command\",\"appium_logs_url\":\"http://api.lambdatest.com/automation/api/v1/sessions/bc02fd99593f14e37850745d66197f89/log/appium\",\"screenshot_url\":\"https://s3.amazonaws.com/ml-screenshots/00HIR-IQNLL-SDVHV-KDTBM/video/index.m3u8\",\"video_url\":\"https://d15x9hjibri3lt.cloudfront.net/00HIR-IQNLL-SDVHV-KDTBM/screenshots.zip\",\"customData\":{}},\"message\":\"Retrieve session was successful\",\"status\":\"success\"}";

        JSONObject jsonObject = new JSONObject(jsonString);
        String testId = jsonObject.getJSONObject("data").getString("test_id");
        System.out.println("Test ID: " + testId);
    }

}
