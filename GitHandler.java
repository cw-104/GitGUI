//Jason Jackson

import git.tools.client.GitSubprocessClient;

import java.io.File;
import java.io.PrintWriter;

public class GitHandler {

    public static void initializeGitRepo(String path) throws Exception {
        GitSubprocessClient client = new GitSubprocessClient(path);
        client.runGitCommand("init");
    }

    public static void addIgnoreAndReadme(String path, String projectName) throws Exception {
        File gitignore = new File(path, ".gitignore");
        try (PrintWriter out = new PrintWriter(gitignore)) {
            out.println("*.class\n*.jar\n.idea/\n.vscode/\n.DS_Store");
        }

        File readme = new File(path, "README.md");
        try (PrintWriter out = new PrintWriter(readme)) {
            out.println("# " + projectName);
        }
    }

    public static void initialCommit(String path) throws Exception {
        GitSubprocessClient client = new GitSubprocessClient(path);
        client.runGitCommand("add .");
        client.runGitCommand("commit -m \"Initial commit\"");
    }

    public static void setRemote(String path, String repoUrl) throws Exception {
        GitSubprocessClient client = new GitSubprocessClient(path);
        client.runGitCommand("remote add origin " + repoUrl);
    }

    public static void pushToRemote(String path) throws Exception {
        GitSubprocessClient client = new GitSubprocessClient(path);
        client.runGitCommand("push -u origin master");
    }
} 
