# PokeInfo-Collector

PokeInfo-Collector는 PokéAPI를 활용하여 포켓몬의 기본 정보와 진화 정보를 자동으로 GitHub Issue로 등록하는 도구입니다. 포켓몬의 이름, 타입, 키, 몸무게, 능력치, 진화 정보 등을 수집하고 이를 GitHub Issues에 이슈로 생성할 수 있습니다.

## 주요 기능

- **포켓몬 정보 자동 등록**: 포켓몬의 이름, 타입, 키, 몸무게, 능력치, 진화 정보를 GitHub Issue로 등록합니다.
- **GitHub Issues 활용**: 각 포켓몬에 대한 정보가 GitHub의 Issue로 하루에 한번씩 자동 생성되어 관리됩니다.
- **Markdown 포맷 지원**: GitHub Issue의 `body`는 Markdown 형식을 지원하여, 포켓몬 정보를 보기 좋게 제공합니다.
- **자동화된 데이터 수집**: PokéAPI에서 데이터를 받아와 자동으로 이슈를 생성하는 시스템입니다.

## 사용 방법

### 1. 환경 설정

- Java 11 이상이 필요합니다.
- 프로젝트를 로컬 환경에 클론합니다.

```bash
git clone https://github.com/soheeGit/PokeInfo-Collector.git
cd PokeInfo-Collector
```
GitHub Personal Access Token을 발급받아 환경 변수로 설정합니다.

GitHub Personal Access Token [발급 링크](https://github.com/settings/tokens)

환경 변수 설정 (예: macOS/Linux):
```bash
export GH_TOKEN="your_personal_access_token"
```

### 2. 의존성 설치
pom.xml 파일에 명시된 의존성을 Maven을 통해 설치합니다.

### 3. GitHub Issue 내용
포켓몬 정보가 GitHub Issue로 등록되면, 아래와 같은 형식으로 출력됩니다:


<img width="943" alt="image" src="https://github.com/user-attachments/assets/a036a77a-b4ab-4e53-a925-67859d59b76e" />

