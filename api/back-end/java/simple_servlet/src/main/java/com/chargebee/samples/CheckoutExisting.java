package com.chargebee.samples;

import com.chargebee.Environment;
import com.chargebee.Result;
import com.chargebee.models.HostedPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkout_existing", value = {"generate_checkout_existing_url"})
public class CheckoutExisting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String subscriptionId = "1mhuIhIQhDeD9KFIJ";
        Result result = null;
        try {
            result = HostedPage.checkoutExisting()
                    .subscriptionId(subscriptionId).request(new Environment("vivek1-test", "test_0kMishobocuobez4OlrbwultwfHfT51fE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HostedPage hostedPage = result.hostedPage();
        // Dont add the below header in production. This is only for demo
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        response.getWriter().print(hostedPage.jsonObj);
    }
}
