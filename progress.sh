#!/bin/bash

BASE_DIR="exercise"
README="README.md"

echo "Updating progress..."

output="## 📊 Progress\n\n"
output+="| Part | Done | Total | Progress |\n"
output+="|------|------|-------|----------|\n"

total_done=0
total_all=0

for part in $(ls -d $BASE_DIR/part*/ | sed -E 's#.*/(part[0-9]+).*#\1#' | sort -u); do
  total_part=$(ls -d $BASE_DIR/$part-* 2>/dev/null | wc -l)

  done_part=$(git log --pretty=format:"%s" \
    | grep "exercise($part)" \
    | sort -u \
    | wc -l)

  total_done=$((total_done + done_part))
  total_all=$((total_all + total_part))

  if [ "$total_part" -eq 0 ]; then
    percent=0
  else
    percent=$((done_part * 100 / total_part))
  fi

  if [ "$done_part" -eq "$total_part" ] && [ "$total_part" -ne 0 ]; then
    status="✅"
  else
    status=""
  fi

  output+="| $part | $done_part | $total_part | ${percent}% $status |\n"
done

# tổng
if [ "$total_all" -eq 0 ]; then
  total_percent=0
else
  total_percent=$((total_done * 100 / total_all))
fi

output+="\n**Total: $total_done / $total_all (${total_percent}%)**\n"

echo -e "$output"

# =========================
# Update README.md
# =========================

if grep -q "## 📊 Progress" "$README"; then
  # replace existing section
  awk -v new_content="$output" '
    BEGIN {found=0}
    /^## 📊 Progress/ {
      print new_content
      found=1
      skip=1
      next
    }
    /^## / && skip==1 {
      skip=0
    }
    skip!=1 {
      print
    }
  ' "$README" > temp.md && mv temp.md "$README"
else
  # append nếu chưa có
  echo -e "\n$output" >> "$README"
fi

echo "README updated ✅"
