package se.coredev.userregistry.repository;

public interface Logger {

	Logger debug(String string);

	Logger info(String string);

	Logger warning(String string);

	Logger error(String string);

}
