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

import fr.imag.adele.cadse.cadseg.pages.build.exporter.ExporterCreationPage1_CreationPage;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.LinkType;

/**
 * @generated
 */
public class JavaRefExporterCreationPage1_CreationPage extends
		ExporterCreationPage1_CreationPage {

	/**
	 * @generated
	 */
	protected JavaRefExporterCreationPage1_CreationPage(final String id,
			final String label, final String title, final String description,
			final boolean isPageComplete, final int hspan) {
		super(id, label, title, description, isPageComplete, hspan);
	}

	/**
	 * @generated
	 */
	public JavaRefExporterCreationPage1_CreationPage(final Item parent,
			final ItemType it, final LinkType lt) {
		super("creation-page1", "Create a new Java content exporter",
				"Create a new Java content exporter", "", false, 3);
		this.parent = parent;
		this.it = it;
		this.lt = lt;
		//this.__short_name__ = createInternalNameField();
		setActionPage(null);
		addLast();

		registerListener();
	}

	@Override
	protected void registerListener() {
		super.registerListener();
		// add init and register
	}
	
	/**
	 * Force this page to be displayed (not empty)
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

}
