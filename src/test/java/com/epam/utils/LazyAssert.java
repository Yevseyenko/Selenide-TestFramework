package com.epam.utils;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import java.util.Map;

public class LazyAssert extends Assertion {
    private Map<AssertionError, IAssert> errorMap = Maps.newHashMap();

    @Override
    public void executeAssert(IAssert a) {
        onBeforeAssert(a);
        try {
            a.doAssert();
            onAssertSuccess(a);
        } catch (AssertionError ex) {
            onAssertFailure(a, ex);
            errorMap.put(ex, a);
        } finally {
            onAfterAssert(a);
        }
    }

    public void assertAll() {
        if (!errorMap.isEmpty()) {
            StringBuilder sb = new StringBuilder("The following asserts failed:\n");
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
