package io.cloud.layer.uitls;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author RippleChan
 * @date 2019-03-06 23:20
 */
@Slf4j
public class RequestUtils {

    /**
     * 参考：
     * https://stackoverflow.com/questions/14525982/getting-request-payload-from-post-request-in-java-servlet
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getBody(HttpServletRequest request,Boolean close) throws IOException {
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (close) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException ex) {
                        throw ex;
                    }
                }
            }
        }
        body = stringBuilder.toString();
        return body;
    }

}
