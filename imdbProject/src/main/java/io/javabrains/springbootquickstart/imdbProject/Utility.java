package io.javabrains.springbootquickstart.imdbProject;

public class Utility {

	public static <T extends AutoCloseable> void closeClosable(T closeable) {
		try {
			if (closeable != null)
				closeable.close();
		} catch (Exception exp) {
			System.out.println(String.format("Could not close resource %s due to %s", exp.getClass().getName(), exp.getMessage(), exp));
		}
	}
}
