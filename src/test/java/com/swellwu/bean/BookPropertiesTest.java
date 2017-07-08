package com.swellwu.bean;

import com.swellwu.Application;
import com.swellwu.config.properties.BookProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class BookPropertiesTest {

    @Autowired
    BookProperties bookProperties;

    @Test
    public void bookTest(){
        assertNotNull(bookProperties);
        assertNotNull(bookProperties.getName());
        assertNotNull(bookProperties.getVersion());
        assertNotNull(bookProperties.getAuthor());
        assertNotNull(bookProperties.getDesc());
        System.out.println(bookProperties.toString());
    }
}