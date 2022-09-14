package com.spring.boot.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class SpringBootMybatisApplicationTests
{

    @Test
    void contextLoads()
    {

    }

    public static void main(String[] args)
    {

        File file = new File("F:\\BaiDuDownload\\ab");
        File[] files = file.listFiles();
        int i = 1;
        for (File file1 : files)
        {
            file1.renameTo(new File("F:\\BaiDuDownload\\ab\\hu" + i));
            i++;
        }
    }


}
