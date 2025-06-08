#!/bin/bash

# AutoEver 기준 디렉터리
ROOT_DIR="$(pwd)"

# 하위 Git 프로젝트 목록 (절대경로 또는 상대경로 지정 가능)
REPOS=(
  "vue/initialized-vue-tailwind"
  "vue/vue-web-app"
  "java/CarPractice"
  "java/JavaBasics"
  "backend/sample-jpa-myslq-0605"
  "compo-styling"
)

for repo in "${REPOS[@]}"; do
  REPO_NAME=$(basename "$repo")
  TEMP_DIR="../${REPO_NAME}_temp"

  echo "🔄 처리 중: $repo"

  # 1. 폴더 임시 이동
  mv "$repo" "$TEMP_DIR"

  # 2. remote 등록 및 fetch
  git remote add "$REPO_NAME" "$TEMP_DIR"
  git fetch "$REPO_NAME"

  # 3. 병합
  git merge --allow-unrelated-histories --no-commit "$REPO_NAME/main" 2>/dev/null || \
  git merge --allow-unrelated-histories --no-commit "$REPO_NAME/master"

  # 4. 병합된 파일을 원래 폴더로 이동
  mkdir -p "$repo"
  git ls-tree --name-only -r HEAD | grep -v "^$repo/" | grep -v '^README.md$' | xargs -I{} git mv {} "$repo/"

  # 5. 커밋
  git commit -m "refactor($REPO_NAME): merge $REPO_NAME project with full history"

  # 6. 정리
  git remote remove "$REPO_NAME"
  rm -rf "$TEMP_DIR"

  echo "✅ 완료: $repo"
  echo ""
done

echo "🎉 모든 하위 Git 프로젝트 통합 완료!"