package constants;

import org.springframework.lang.Nullable;

public enum OS {
	WINDOWS,
	LINUX;

	@Nullable
	public static OS of(String name) {
		for (OS os : values()) {
			if (name != null && name.toUpperCase().contains(os.name())) {
				return os;
			}
		}
		return null;
	}
}
