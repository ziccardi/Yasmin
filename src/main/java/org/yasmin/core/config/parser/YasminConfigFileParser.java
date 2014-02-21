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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * This object is able to parse a generic Yasmin configuration file.
 * 
 * @author Massimiliano Ziccardi
 */
public class YasminConfigFileParser {

	/**
	 * The delegate that will receive all the parsed tokens.
	 */
	private final IYasminConfigParserDelegate parserDelegate;

	/**
	 * Builds the parser and initialize it with the given delegate object.
	 * 
	 * @param delegate
	 *            the delegate that will receive all the parsed tokens
	 */
	public YasminConfigFileParser(IYasminConfigParserDelegate delegate) {
		parserDelegate = delegate;
	}

	/**
	 * Parse the specified configuration file.
	 * 
	 * @param configFile
	 *            The file to be parsed
	 */
	public final void parse(File configFile) {

		IStateMachine stateMachine = parserDelegate.getStateMachine();

		try (BufferedReader reader = new BufferedReader(new FileReader(
				configFile))) {

			for (String line = reader.readLine(); line != null; line = reader
					.readLine()) {
				IYasminConfigToken token = TokenFactory.produceToken(line);
				if (token != null) {
					State newState = stateMachine.moveTo(token.getType());
					if (newState != null) {
						parserDelegate.receive(token);
					} else {
						// TODO: invalid token found...
						System.out
								.println("**** bad state invalid token found");
					}
				} else {
					// TODO: invalid token found...
					System.out
							.println("**** unknown token invalid token found");
				}
			}

			if (stateMachine.moveTo(ConfigTokenType.end) != null) {
				parserDelegate.validate();
			} else {
				// Unexpected End Of File...
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
