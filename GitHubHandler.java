// Jason Jackson

import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
//not bugged

public class GitHubHandler {

    public static String createRemoteRepo(String token, String name, String desc, boolean isPrivate) throws Exception {
        GitHubApiClient client = new GitHubApiClient(token);
        GitHubRepo repo = new GitHubRepo(name, desc, !isPrivate);
        GitHubRepo createdRepo = client.createRepository(repo);
        return createdRepo.getCloneUrl();
    }

}
