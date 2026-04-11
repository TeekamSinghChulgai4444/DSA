# ⚙️ Setup Guide — Secrets & Auto-Sync Configuration

Follow these steps after uploading this repo to GitHub.

---

## Step 1 — Add GitHub Secrets

Go to your repo → **Settings** → **Secrets and variables** → **Actions** → **New repository secret**

Add all of the following secrets:

### 1. GH_TOKEN (required for all workflows)
1. Go to https://github.com/settings/tokens
2. Click "Generate new token (classic)"
3. Give it any name, e.g. `dsa-practice-sync`
4. Check the `repo` checkbox
5. Click "Generate token" and copy it immediately
6. Add as secret named: `GH_TOKEN`

### 2. LEETCODE_CSRF_TOKEN + LEETCODE_SESSION (for LeetCode workflow)
1. Open https://leetcode.com and log in
2. Right-click anywhere → Inspect → Network tab
3. Refresh the page
4. Click on any request to `leetcode.com`
5. Under "Request Headers" find the `cookie:` field
6. Copy the value of `csrftoken=...` → add as `LEETCODE_CSRF_TOKEN`
7. Copy the value of `LEETCODE_SESSION=...` → add as `LEETCODE_SESSION`

### 3. CF_HANDLE (for Codeforces workflow)
- Your Codeforces handle is: `teekam.singh`
- Add as secret named: `CF_HANDLE`
- Value: `teekam.singh`

---

## Step 2 — Enable GitHub Actions

1. Go to your repo → **Settings** → **Actions** → **General**
2. Under "Workflow permissions" select **Read and write permissions**
3. Click Save

---

## Step 3 — Install Chrome Extensions (for instant sync)

The GitHub Actions sync every few hours. For *instant* sync the moment you get Accepted, also install these Chrome extensions:

| Platform | Extension | What it does |
|---|---|---|
| LeetCode | [LeetHub 2.0](https://github.com/arunbhardwaj/LeetHub-2.0) | Pushes to GitHub instantly on Accepted |
| Codeforces | [CFPusher](https://chromewebstore.google.com/detail/cfpusher-codeforces-to-gi/eiffefcjnaanflbhcmgjlaoilhpkbael) | Pushes to GitHub instantly on Accepted |
| CodeChef | [CodeSync](https://github.com/rithikg24/CodeSync) | Pushes to GitHub instantly on Accepted |

---

## Step 4 — Customize your README.md

Open `README.md` and replace every `YOUR_USERNAME` with your actual username on each platform.

---

## Step 5 — Run your first sync manually

1. Go to your repo → **Actions** tab
2. Click "Sync LeetCode submissions" → "Run workflow" → "Run workflow"
3. Click "Sync Codeforces submissions" → "Run workflow" → "Run workflow"
4. Watch your past solutions appear in the repo automatically!

---

## Troubleshooting

**Workflow fails with "permission denied":**
→ Check that GH_TOKEN has `repo` scope and that Actions has Read & Write permissions (Step 2)

**LeetCode sync not finding submissions:**
→ Your LEETCODE_CSRF_TOKEN or LEETCODE_SESSION may have expired. Repeat Step 1.2 to get fresh values.

**Codeforces sync not finding submissions:**
→ Make sure CF_HANDLE is set to `teekam.singh` (your exact Codeforces handle).
