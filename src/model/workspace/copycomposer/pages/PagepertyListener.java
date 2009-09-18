/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package model.workspace.copycomposer.pages;

import fede.workspace.model.manager.properties.impl.ui.DCheckBoxUI;
import fede.workspace.model.manager.properties.impl.ui.DTextUI;
import fr.imag.adele.cadse.core.ui.EventAdapter;
import fr.imag.adele.cadse.core.ui.UIField;

public class PagepertyListener extends EventAdapter {

	private final DCheckBoxUI	has_c;
	private final DCheckBoxUI	has_s;
	private final DTextUI		fs;
	private final DTextUI		fc;

	public PagepertyListener(final DCheckBoxUI hc, final DCheckBoxUI hs, final DTextUI fc, final DTextUI fs) {
		this.has_c = hc;
		this.has_s = hs;
		this.fs = fs;
		this.fc = fc;
		hc.addListener(this);
		hs.addListener(this);
	}

	@Override
	public void notifieValueChanged(final UIField field, final Object value) {
		if (field == has_c) {
			fc.setEnabled(Boolean.TRUE.equals(value));
		}
		if (field == has_s) {
			fs.setEnabled(Boolean.TRUE.equals(value));
		}
	}

}
