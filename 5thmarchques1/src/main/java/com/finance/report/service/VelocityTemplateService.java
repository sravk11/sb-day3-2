package com.finance.report.service;

import com.finance.report.model.*;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.List;
import java.util.Properties;

public class VelocityTemplateService {
    public String generateStatement(User user, List<Transaction> transactions, AccountSummary summary, BankDetails bank) {
        VelocityEngine velocityEngine = new VelocityEngine();
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "file");
        properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        velocityEngine.init(properties);

        VelocityContext context = new VelocityContext();
        context.put("user", user);
        context.put("transactions", transactions);
        context.put("summary", summary);
        context.put("bank", bank);

        StringWriter writer = new StringWriter();
        velocityEngine.getTemplate("src/main/resources/templates/monthly_statement.vm").merge(context, writer);

        return writer.toString();
    }
}
