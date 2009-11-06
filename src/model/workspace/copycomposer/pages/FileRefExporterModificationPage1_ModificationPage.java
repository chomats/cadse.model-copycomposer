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

import model.workspace.copycomposer.CopyComposerCST;
import fede.workspace.model.manager.properties.impl.ic.IC_DefaultForList;
import fede.workspace.model.manager.properties.impl.ui.DListUI;
import fede.workspace.model.manager.properties.impl.ui.DTextUI;
import fr.imag.adele.cadse.cadseg.IC_ItemTypeTemplateForText;
import fr.imag.adele.cadse.cadseg.managers.content.ManagerManager;
import fr.imag.adele.cadse.cadseg.pages.build.exporter.ExporterModificationPage1_ModificationPage;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.impl.ui.mc.MC_AttributesItem;
import fr.imag.adele.cadse.core.impl.ui.mc.MC_DefaultForList;
import fr.imag.adele.cadse.core.ui.EPosLabel;

/**
 * @generated
 */
public class FileRefExporterModificationPage1_ModificationPage extends
		ExporterModificationPage1_ModificationPage {

	/**
	 * @generated
	 */
	static public class ExportedFolderMC extends MC_AttributesItem {

		/**
		 * @generated
		 */
		public ExportedFolderMC() {
			super();
		}

		@Override
		public Object defaultValue() {
			return ""; // by default, we expose all the project
		}
	}

	/**
	 * @generated
	 */
	protected DTextUI fieldExportedFolder;

	/**
	 * @generated
	 */
	protected FileRefExporterModificationPage1_ModificationPage(
			final String id, final String label, final String title,
			final String description, final boolean isPageComplete,
			final int hspan) {
		super(id, label, title, description, isPageComplete, hspan);
	}

	/**
	 * @generated
	 */
	public FileRefExporterModificationPage1_ModificationPage(final Item item) {
		super("modification-page1", "Folder Content Exporter",
				"Folder Content Exporter", "", false, 3);
		this.item = item;
		this.__short_name__ = createInternalNameField();
		this.fieldExportedFolder = createFieldExportedFolder();
		this.fieldTypes = createFieldTypes();
		setActionPage(null);
		addLast(this.__short_name__, this.fieldExportedFolder, this.fieldTypes);

		registerListener();
	}

	@Override
	protected void registerListener() {
		super.registerListener();
		// add init and register
	}

	/**
	 * 
	 */
	public DTextUI createFieldExportedFolder() {
		final ExportedFolderMC mc = new ExportedFolderMC();
		return new DTextUI(
				CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER,
				"Folder to export:", EPosLabel.left, mc,
				new IC_ItemTypeTemplateForText() {
					@Override
					protected Item getItemFromContext() {
						final Item manager = getContext().getPartParent();
						return ManagerManager.getItemType(manager);
					}
				}, 0, 1, "");
	}

	/**
	 * @generated
	 */
	@Override
	public DListUI createFieldTypes() {
		MC_DefaultForList mc = new MC_DefaultForList(1, -1);
		IC_DefaultForList ic = new IC_DefaultForList("add a type",
				"the string represent a exported type", false);
		return new DListUI(fr.imag.adele.cadse.core.CadseGCST.EXPORTER_at_TYPES, "content types",
				EPosLabel.top, mc, ic, true, false, false, false);
	}

}
