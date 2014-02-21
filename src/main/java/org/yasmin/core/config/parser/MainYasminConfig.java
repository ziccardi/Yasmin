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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * This object holds the main Yasmin configuration file properties.
 * 
 * @author Massimiliano Ziccardi
 */
public class MainYasminConfig implements IYasminConfigParserDelegate {

	/**
	 * A map containing all the configured values.
	 */
	private Map<String, String> config = new HashMap<String, String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.yasmin.core.config.parser.IYasminConfigParserDelegate#getStateMachine
	 * ()
	 */
	@Override
	public IStateMachine getStateMachine() {
		return new MainConfigFileStateMachine();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.yasmin.core.config.parser.IYasminConfigParserDelegate#receive(org
	 * .yasmin.core.config.parser.IYasminConfigToken)
	 */
	@Override
	public void receive(IYasminConfigToken token) {
		switch (token.getType()) {
		case emptyLine:
		case comment:
			// SKIP
			break;
		case kvpair:

			KeyValueToken kvtoken = (KeyValueToken) token;

			// FIXME: some key can be present more than one time...
			config.put(kvtoken.getKey(), kvtoken.getValue());
			break;
		default:
			// Never happens : Unexpected token...
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.yasmin.core.config.parser.IYasminConfigParserDelegate#validate()
	 */
	@Override
	public void validate() {
	}

	// TODO : remove. Just used to test...
	public static void main(String[] args) {
		new YasminConfigFileParser(new MainYasminConfig()).parse(new File(
				"src/test/resources/config/Yasmin.cfg"));
	}

}
