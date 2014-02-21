/*
 * Copyright (c) 2014 Frederico Campos & Massimiliano Ziccardi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.yasmin.core.config.parser;

import org.apache.commons.lang3.StringUtils;

/**
 * This class represent a key/value pair. As per Yasmin documentatio, key value
 * pairs must start at the first column, without any leading space.
 * 
 * @author Massimiliano Ziccardi
 */
class KeyValueToken extends ConfigTokenBase {

	/**
	 * Regex used to validate key name.
	 */
	private final static String KEY_REGEX = "[a-zA-Z]{1}[a-zA-Z0-9_-]*";

	/**
	 * The key name.
	 */
	private String key;

	/**
	 * The key value.
	 */
	private String value;

	/**
	 * Initializes the object with an empty line. Used only by the
	 * {@link TokenFactory} object.
	 */
	KeyValueToken() {
		super();
	}

	/**
	 * Initializes the token with the given line.
	 * 
	 * @param line
	 *            the line to be parsed
	 */
	private KeyValueToken(String line) {
		super(line);
		init(line);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.yasmin.core.config.parser.IYasminConfigToken#getType()
	 */
	@Override
	public ConfigTokenType getType() {
		return ConfigTokenType.kvpair;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.yasmin.core.config.parser.IYasminConfigToken#parse(java.lang.String)
	 */
	@Override
	public IYasminConfigToken parse(String line) {
		if (!isValid(line)) {
			return null;
		}
		return new KeyValueToken(line);
	}

	/**
	 * Checks if the given line is a valid keypair line.
	 * 
	 * @param line
	 *            The line to be verified
	 * @return <code>true</code> if the line is a valid keypair line.
	 */
	private boolean isValid(String line) {
		if (!Character.isAlphabetic(line.charAt(0))) {
			return false;
		}

		// Line must not end with {
		if (StringUtils.strip(line).endsWith("{")) {
			return false;
		}

		int equalIndex = line.indexOf("=");
		// Starts with a character... it must have an equal sign...
		if (equalIndex == -1) {
			return false;
		}

		// Equal sign found... Let's validate the key...
		String keyName = line.substring(0, equalIndex);
		if (!keyName.matches(KEY_REGEX)) {
			return false;
		}

		return true;
	}

	/**
	 * Extracts keyname and value from the line.
	 * 
	 * @param line
	 *            the raw line
	 */
	private void init(String line) {
		int equalIndex = line.indexOf("=");
		key = line.substring(0, equalIndex);
		value = line.substring(equalIndex + 1);
	}

	/**
	 * @return the key name
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
