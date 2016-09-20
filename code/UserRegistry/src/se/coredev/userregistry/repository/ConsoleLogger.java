package se.coredev.userregistry.repository;

public final class ConsoleLogger implements Logger {

	@Override
	public Logger debug(String string) {
		System.err.println(String.format("[DEBUG] :%s", string));
		return this;
	}

	@Override
	public Logger info(String string) {
		System.err.println(String.format("[INFO] :%s", string));
		return this;
	}

	@Override
	public Logger warning(String string) {
		System.err.println(String.format("[WARNING] :%s", string));
		return this;
	}

	@Override
	public Logger error(String string) {
		System.err.println(String.format("[ERROR] :%s", string));
		return this;
	}

}
