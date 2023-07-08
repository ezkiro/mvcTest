package com.toyfactory.mvcTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.toyfactory.mvcTest.model.NestedObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
public class ObjectMapperTest {

    private final String TEST_JSON = "{\"name\":\"test1\",\"someResultList\":[{\"resultCode\":\"100\",\"resultMessage\":\"success\"},{\"resultCode\":\"200\",\"resultMessage\":\"fail\"}]}";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testNestedObject() {

        try {
            var nestedObject = objectMapper.readValue(TEST_JSON, NestedObject.class);
            log.debug("nestedObject:{}", nestedObject);

            assertTrue(nestedObject.getName().equals("test1"));
            assertEquals(nestedObject.getSomeResultList().size(), 2);
            assertTrue(nestedObject.getSomeResultList().get(0).getResultCode().equals("100"));
            assertTrue(nestedObject.getSomeResultList().get(0).getResultMessage().equals("success"));

        } catch (Exception e) {
            log.error("exception!!", e);
        }

        var nestedObject = new NestedObject();
        nestedObject.setName("test1");
        nestedObject.addSomeResult("100", "success");
        nestedObject.addSomeResult("200", "fail");

        try {
            var json = objectMapper.writeValueAsString(nestedObject);
            log.debug("json:{}", json);

            assertTrue(json.equals(TEST_JSON));

        } catch (Exception e) {
            log.error("exception!!", e);
        }
    }
}
