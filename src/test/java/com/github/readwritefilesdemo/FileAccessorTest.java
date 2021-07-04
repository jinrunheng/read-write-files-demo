package com.github.readwritefilesdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

class FileAccessorTest {

    @Test
    public void test1() throws Exception {
        File tmp = File.createTempFile("tmp", "");
        List<String> list = Arrays.asList("a", "b", " ", "   ", "c");
        FileAccessor.writeLinesToFile1(list, tmp);
        Assertions.assertEquals(list, FileAccessor.readFile1(tmp));
    }

    @Test
    public void test2() throws Exception{
        File tmp = File.createTempFile("tmp", "");
        List<String> list = Arrays.asList("a", "b", " ", "   ", "c");
        FileAccessor.writeLinesToFile2(list, tmp);
        Assertions.assertEquals(list, FileAccessor.readFile2(tmp));
    }

    @Test
    public void test3() throws Exception{
        File tmp = File.createTempFile("tmp", "");
        List<String> list = Arrays.asList("a", "b", " ", "   ", "c");
        FileAccessor.writeLinesToFile3(list, tmp);
        Assertions.assertEquals(list, FileAccessor.readFile3(tmp));
    }

    @Test
    public void test4() throws Exception{
        File tmp = File.createTempFile("tmp", "");
        List<String> list = Arrays.asList("a", "b", " ", "   ", "c");
        FileAccessor.writeLinesToFile4(list, tmp);
        Assertions.assertEquals(list, FileAccessor.readFile4(tmp));
    }
}