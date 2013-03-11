package com.jetbrains.crucible.ui.toolWindow;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.jetbrains.crucible.connection.CrucibleFilter;
import com.jetbrains.crucible.connection.CrucibleManager;
import com.jetbrains.crucible.connection.exceptions.CrucibleApiException;
import com.jetbrains.crucible.model.BasicReview;
import org.jdom.JDOMException;

import javax.swing.*;
import java.util.List;

/**
 * User: ktisha
 */
public class CrucibleReviewModel extends DefaultListModel {
  private static final Logger LOG = Logger.getInstance(CrucibleReviewModel.class.getName());
  private final Project myProject;

  public CrucibleReviewModel(Project project) {
    myProject = project;
  }

  public void updateModel(CrucibleFilter filter) {
    removeAllElements();
    final CrucibleManager manager = CrucibleManager.getInstance(myProject);
    final List<BasicReview> reviews;
    try {
      reviews = manager.getReviewsForFilter(filter);
      for (BasicReview review : reviews) {
        addElement(review);
      }
    }
    catch (CrucibleApiException e) {
      LOG.warn(e.getMessage());
    }
    catch (JDOMException e) {
      LOG.warn(e.getMessage());
    }
  }
}
