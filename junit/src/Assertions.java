// @formatter:off
public class Assertions {

  void assertTrue(boolean condition) { }
  void assertFalse(boolean condition) { }

  void assertNull(Object actual) { }
  void assertNotNull(Object actual) { }

  void assertEquals(short expected, short actual) { }
  void assertEquals(byte expected, byte actual) { }
  void assertEquals(int expected, int actual) { }
  void assertEquals(long expected, long actual) { }
  void assertEquals(char expected, char actual) { }
  void assertEquals(float expected, float actual) { }
  void assertEquals(double expected, double actual) { }
  void assertEquals(Object expected, Object actual) { }

  void assertNotEquals(Object unexpected, Object actual) { }

  void assertArrayEquals(Object[] expected, Object[] actual) { }
  void assertLinesMatch(List<String> expectedLines, List<String> actualLines) { }

  void assertSame(Object expected, Object actual) { }
  void assertNotSame(Object unexpected, Object actual) { }
  void assertAll(Collection<Executable> executables) { }
  void assertTimeout(Duration timeout, Executable executable) { }

  <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable) { }
}
