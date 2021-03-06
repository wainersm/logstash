package org.logstash.ingest;

import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

public final class DateTest extends IngestTest {

    @Parameters
    public static Iterable<String> data() {
        return Arrays.asList("Date", "DateExtraFields", "DotsInDateField");
    }

    @Test
    public void convertsDateFieldCorrectly() throws Exception {
        final String date = getResultPath(temp);
        Date.main(resourcePath(String.format("ingest%s.json", testCase)), date);
        assertThat(
            utf8File(date), is(utf8File(resourcePath(String.format("logstash%s.conf", testCase))))
        );
    }
}
