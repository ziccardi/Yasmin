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
 * This class represent a comment found inside a configuration file
 * 
 * @author Massimiliano Ziccardi
 */
class CommentToken extends ConfigTokenBase {

	private final static String COMMENT_PREFIX = "#";

	/**
	 * This constructor is used only by the TokenFactory class because it needs
	 * an instance of the token to check the type of token to be created.
	 */
	CommentToken() {
		super();
	}

	/**
	 * This contructor is called by the {@link #parse(String)} method to produce
	 * a token parsing the given configuration line.
	 * 
	 * @param line
	 *            The configuration line
	 */
	private CommentToken(String line) {
		super(line);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.yasmin.core.config.parser.IYasminConfigToken#getType()
	 */
	@Override
	public ConfigTokenType getType() {
		return ConfigTokenType.comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.yasmin.core.config.parser.IYasminConfigToken#parse(java.lang.String)
	 */
	@Override
	public IYasminConfigToken parse(String line) {
		if (StringUtils.strip(line).startsWith(COMMENT_PREFIX)) {
			return new CommentToken(line);
		}

		return null;
	}
}
