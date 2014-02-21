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
 * Represent an empty line token.
 * 
 * @author Massimiliano Ziccardi
 */
class EmptyLineToken extends ConfigTokenBase {

	/**
	 * Initializes the object.
	 */
	EmptyLineToken() {
		super();
	}

	/**
	 * Initializes the object and parse the given configuration line.
	 * 
	 * @param line
	 *            The configuration line to be parsed
	 */
	private EmptyLineToken(String line) {
		super(line);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.yasmin.core.config.parser.IYasminConfigToken#getType()
	 */
	@Override
	public ConfigTokenType getType() {
		return ConfigTokenType.emptyLine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.yasmin.core.config.parser.IYasminConfigToken#parse(java.lang.String)
	 */
	@Override
	public IYasminConfigToken parse(String line) {
		if (StringUtils.isEmpty(line)) {
			return new EmptyLineToken(line);
		}
		return null;
	}

}
