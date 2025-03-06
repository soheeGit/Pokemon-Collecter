package github;

import pokemon.Pokemon;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Github {
    String token = System.getenv("GH_TOKEN");
    String OWNER = "soheeGit";
    String REPO = "Pokemon-Collecter";

    public void createGitHubIssue(String name, String image, List<Pokemon.Type> types, String height, String weight,
                                  int hp, int attack, int defense, int spAttack, int spDefense, int speed,
                                  String basePokemon, String firstEvolutionName, String secondEvolutionName) {
        try {
            // 타입을 동적으로 처리하는 부분
            String typesString = String.join(", ", types.stream().map(type -> type.getType().getName()).toList());

            // 기본 능력치 부분을 동적으로 생성
            StringBuilder statsBuilder = new StringBuilder();
            statsBuilder.append(String.format(" - **HP**: %d\\n", hp));
            statsBuilder.append(String.format(" - **공격**: %d\\n", attack));
            statsBuilder.append(String.format(" - **방어**: %d\\n", defense));
            statsBuilder.append(String.format(" - **특수 공격**: %d\\n", spAttack));
            statsBuilder.append(String.format(" - **특수 방어**: %d\\n", spDefense));
            statsBuilder.append(String.format(" - **스피드**: %d\\n", speed));

            // GitHub Issue의 JSON Body
            String jsonBody = String.format("""
                        {
                          "title": "오늘의 포켓몬: %s",
                          "body": "## 오늘의 포켓몬: %s\\n\\n![포켓몬 이미지](%s)\\n\\n\\n\\n#### 🔹 기본 정보\\n- **이름**: %s\\n- **타입**: %s\\n- **키**: %sm\\n- **몸무게**: %skg\\n\\n#### 💪 기본 능력치\\n%s\\n\\n---\\n\\n#### 🔄 진화 정보\\n- **기본포켓몬**: %s\\n- **첫 번째 진화**: %s\\n- **두 번째 진화**: %s\\n\\n📌 *PokéAPI 데이터를 기반으로 자동 생성된 이슈입니다.*"
                        }
                    """, name, name, image, name, typesString, height, weight, statsBuilder.toString(), basePokemon, firstEvolutionName, secondEvolutionName != null && !secondEvolutionName.isEmpty() ? secondEvolutionName : "없음");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/repos/%s/%s/issues".formatted(OWNER, REPO)))
                    .header("Authorization", "Bearer " + token)
                    .header("Accept", "application/vnd.github.v3+json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // GitHub API 응답 출력
            System.out.println("GitHub Issue Response: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
