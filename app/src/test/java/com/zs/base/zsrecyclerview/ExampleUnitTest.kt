package com.zs.base.zsrecyclerview

import org.junit.Test
import java.lang.ref.WeakReference

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    var weak : WeakReference<TestClass>? = WeakReference(TestClass())

    var text = "asdfasdf"

    @Test
    fun aaa() {
        weakTest()
        zzz()
    }

    @Test
    fun weakTest() {
        var weak2 = weak?.get()
        weak2 = null
        //System.gc()
        text = "zzzzzzzzzzzzzz"
        println(weak?.get())
    }

    @Test
    fun zzz() {
        println(text)
    }

    class TestClass() {
        var text: String = "aasdf"

        override fun toString(): String {
            return text
        }
    }
}
