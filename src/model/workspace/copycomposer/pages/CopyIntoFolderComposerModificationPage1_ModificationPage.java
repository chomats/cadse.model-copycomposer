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

import fede.workspace.model.manager.properties.FieldsCore;
import fede.workspace.model.manager.properties.IInteractionControllerForList;
import model.workspace.copycomposer.CopyComposerCST;
import fede.workspace.model.manager.properties.impl.ic.IC_LinkForBrowser_Combo_List;
import fede.workspace.model.manager.properties.impl.ic.IC_DefaultForList;
import fede.workspace.model.manager.properties.impl.mc.LinkModelController;
import fede.workspace.model.manager.properties.impl.mc.MC_DefaultForList;
import fede.workspace.model.manager.properties.impl.mc.StringToBooleanModelControler;
import fede.workspace.model.manager.properties.impl.ui.DCheckBoxUI;
import fede.workspace.model.manager.properties.impl.ui.DListUI;
import fede.workspace.model.manager.properties.impl.ui.DTextUI;
import fr.imag.adele.cadse.cadseg.IC_ItemTypeTemplateForText;
import fr.imag.adele.cadse.cadseg.WorkspaceCST;
import fr.imag.adele.cadse.cadseg.managers.build.CompositeItemTypeManager;
import fr.imag.adele.cadse.cadseg.managers.content.ManagerManager;
import fr.imag.adele.cadse.cadseg.pages.build.composer.EclipseComposerModificationPage1_ModificationPage;
import fr.imag.adele.cadse.core.IItemNode;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.impl.ui.MC_AttributesItem;
import fr.imag.adele.cadse.core.impl.ui.PageImpl;
import fr.imag.adele.cadse.core.ui.EPosLabel;
import fr.imag.adele.cadse.core.ui.IActionPage;
import fr.imag.adele.cadse.core.ui.IModelController;
import fr.imag.adele.cadse.core.ui.IPage;
import fr.imag.adele.cadse.core.ui.PageFactory;
import fr.imag.adele.cadse.core.ui.UIField;

/**
 * @generated
 */
public class CopyIntoFolderComposerModificationPage1_ModificationPage extends
		EclipseComposerModificationPage1_ModificationPage {

	/**
	 * @generated
	 */
	static public class TargetFolderMC extends MC_AttributesItem {

		/**
		 * @generated
		 */
		public TargetFolderMC() {
			super();
		}

		@Override
		public Object defaultValue() {
			return ""; // by default, we copy to root directory
		}

	}

	/**
	 * @generated
	 */
	protected DTextUI fieldTargetFolder;

	/**
	 * @generated
	 */
	protected DListUI fieldManagesLT;

	private DCheckBoxUI fieldExtendsClass;

	/**
	 * @generated
	 */
	protected CopyIntoFolderComposerModificationPage1_ModificationPage(
			final String id, final String label, final String title,
			final String description, final boolean isPageComplete,
			final int hspan) {
		super(id, label, title, description, isPageComplete, hspan);
	}

	/**
	 * @generated
	 */
	public CopyIntoFolderComposerModificationPage1_ModificationPage(
			final Item item) {
		super("modification-page1", "Folder Content Copy Composer",
				"Folder Content Copy Composer", "", false, 3);
		this.item = item;
		this.__short_name__ = createInternalNameField();
		this.fieldTargetFolder = createFieldTargetFolder();
		this.fieldManagesLT = createFieldManagesLT();
		this.fieldTypes = createFieldTypes();
		this.fieldExtendsClass = createFieldExtendsClass();
		setActionPage(null);
		addLast(this.__short_name__, this.fieldTargetFolder,
				this.fieldManagesLT, this.fieldTypes, this.fieldExtendsClass);

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
	public DTextUI createFieldTargetFolder() {
		final TargetFolderMC mc = new TargetFolderMC();
		return new DTextUI(
				CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER,
				"Target Folder:", EPosLabel.left, mc,
				new IC_ItemTypeTemplateForText() {
					@Override
					protected Item getItemFromContext() {
						final Item compositeItemType = getContext()
								.getPartParent();
						final Item itemType = CompositeItemTypeManager
								.getItemType(compositeItemType);
						return itemType;
					}
				}, 0, 1, "");
	}

	/**
	 * @generated
	 */
	public DCheckBoxUI createFieldExtendsClass() {
		StringToBooleanModelControler mc = new StringToBooleanModelControler();
		return new DCheckBoxUI(WorkspaceCST.COMPOSER_at_EXTENDS_CLASS,
				"extends generated class", EPosLabel.none, mc, null);
	}

	/**
	 * @generated
	 */
	public DListUI createFieldManagesLT() {
		LinkModelController mc = new LinkModelController(true, null,
				CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT);
		IC_LinkForBrowser_Combo_List ic = new IC_LinkForBrowser_Combo_List(
				"Select a composition link type.",
				"Select a composition link type.",
				CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT);
		return new DListUI(
				CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT
						.getName(), "Links used to copy folder content",
				EPosLabel.top, mc, ic, true, false, false, false);
	}

	/**
	 * @generated
	 */
	@Override
	public DListUI createFieldTypes() {
		MC_DefaultForList mc = new MC_DefaultForList(1, -1);
		IC_DefaultForList ic = new IC_DefaultForList("add a type.",
				"the string represent a exported type.", false);
		return new DListUI(WorkspaceCST.COMPOSER_at_TYPES, "content types",
				EPosLabel.top, mc, ic, true, false, false, false);
	}

}
