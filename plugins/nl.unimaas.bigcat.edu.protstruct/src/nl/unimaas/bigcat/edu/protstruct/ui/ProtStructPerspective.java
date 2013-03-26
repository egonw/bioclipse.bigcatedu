/* Copyright (c) 2013 Egon Willighagen <egonw@users.sf.net>
 *               
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package nl.unimaas.bigcat.edu.protstruct.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * The BiGCaT Protein Structure perspective.
 */
public class ProtStructPerspective implements IPerspectiveFactory {

	IPageLayout storedLayout;

	public static final String ID_PERSPECTIVE =
		"nl.unimaas.bigcat.edu.protstruct.ui.ProtStructPerspective";

    public static final String ID_NAVIGATOR =
        "net.bioclipse.navigator";

	public void createInitialLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();
        layout.setEditorAreaVisible(true);
        layout.setFixed(false);
        layout.addPerspectiveShortcut(ID_PERSPECTIVE);

        //Add layouts for views
        IFolderLayout left_folder_layout =
            layout.createFolder(
                    "explorer",
                    IPageLayout.LEFT,
                    0.20f,
                    editorArea);

        IFolderLayout right_folder_layout =
            layout.createFolder(
                    "outline",
                    IPageLayout.RIGHT,
                    0.70f,
                    editorArea);

        IFolderLayout bottom_folder_layout =
            layout.createFolder(
                    "properties",
                    IPageLayout.BOTTOM,
                    0.70f,
                    editorArea);

        //Add views
        left_folder_layout.addView(ID_NAVIGATOR);
        bottom_folder_layout.addView(IPageLayout.ID_PROP_SHEET);
        right_folder_layout.addView(IPageLayout.ID_OUTLINE);

        //Add ShowView shortcuts
        layout.addShowViewShortcut(ID_NAVIGATOR);
        layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
        layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
	}

	public IPageLayout getStoredLayout() {
		return storedLayout;
	}

}
