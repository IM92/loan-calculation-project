package com.calculator.price;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

public final class FileUtil {
    private static final String ENCODING = "UTF-8";

    private FileUtil() {}

    public static String readFileContent(String fileName) {
        try {
            return IOUtils.toString(
                    FileUtil.class.getResourceAsStream(fileName),
                    ENCODING
            );
        } catch (IOException e) {
            throw new EndToEndTestException("Could not read file", e);
        }
    }
}
