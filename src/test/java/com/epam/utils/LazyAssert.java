package com.epam.utils;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import java.util.Map;

public class LazyAssert extends Assertion {
    private Map<AssertionError, IAssert> errorMap = Maps.newHashMap();

    @Override
    public void executeAssert(IAssert a) {
        try {
            a.doAssert();
        } catch (AssertionError ex) {
            errorMap.put(ex, a);
        }
    }

    public void assertAll() {
        if (!errorMap.isEmpty()) {
            StringBuilder sb =
                    new StringBuilder("The following asserts failed:\n");
            boolean first = true;
            for (Map.Entry<AssertionError, IAssert> ae : errorMap.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(ae.getValue().getMessage());
            }
            throw new AssertionError(sb.toString());
        }
    }

}
