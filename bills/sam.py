
# main.py
from github_tool import run

if __name__ == "__main__":
    # Change operation/params here as needed.
    result = run("fetch_file", {
        "base_url": "https://api.github.com",
        "owner": "sureshjagannadham",
        "repo": "OneEIghtyProject",
        "path": "Arrays-2/src/RotateMatrix48M.java",
        "token": "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",      # keep empty for now (safe)
        "decode": True,
        "ref": "master"
    })
    print(result)
