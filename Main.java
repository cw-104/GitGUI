// Jason Jackson

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GitHub Repo Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(8, 2));
        JTextField projectPathField = new JTextField();
        JTextField repoNameField = new JTextField();
        JTextField repoDescField = new JTextField();
        JCheckBox privateRepoBox = new JCheckBox("Private Repo");
        JTextField tokenField = new JTextField();
        JButton createButton = new JButton("Create GitHub Repo");
        JTextArea outputArea = new JTextArea(5, 20);

        panel.add(new JLabel("Project Path:"));
        panel.add(projectPathField);
        panel.add(new JLabel("GitHub Repo Name:"));
        panel.add(repoNameField);
        panel.add(new JLabel("Repo Description:"));
        panel.add(repoDescField);
        panel.add(new JLabel("GitHub Token:"));
        panel.add(tokenField);
        panel.add(privateRepoBox);
        panel.add(createButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, new JScrollPane(outputArea));

        createButton.addActionListener((ActionEvent e) -> {
            String path = projectPathField.getText();
            String name = repoNameField.getText();
            String desc = repoDescField.getText();
            boolean isPrivate = privateRepoBox.isSelected();
            String token = tokenField.getText();

            if (path.isEmpty() || name.isEmpty() || token.isEmpty()) {
                outputArea.setText("Missing required input fields.");
                return;
            }

            try {
                GitHandler.initializeGitRepo(path);
                GitHandler.addIgnoreAndReadme(path, name);
                GitHandler.initialCommit(path);

                String url = GitHubHandler.createRemoteRepo(token, name, desc, isPrivate);
                GitHandler.setRemote(path, url);
                GitHandler.pushToRemote(path);

                outputArea.setText("Repository successfully created: " + url);
            } catch (Exception ex) {
                outputArea.setText("Something went wrong: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}
