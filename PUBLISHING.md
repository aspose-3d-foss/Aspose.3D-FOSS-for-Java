# Maven Central Publication Guide

This document describes how to publish `org.aspose:aspose-3d-foss` to Maven Central.
It follows the same pattern used by `org.aspose:aspose-cells-foss` and `org.aspose:aspose-pdf-foss`.

## Quick Reference

- **Coordinate**: `org.aspose:aspose-3d-foss:{version}`
- **Version**: Always matches the commercial Aspose.3D release (e.g. 26.5.0)
- **Java target**: 21 (`maven.compiler.source`/`target` in pom.xml — higher than the
  cells/pdf repos, which target 17/11 respectively; keep this in mind before copying
  workflow snippets between repos)
- **GPG Key ID**: `E176D5CBCA1DCC62` (shared across all Aspose FOSS Java packages)
- **Portal**: https://central.sonatype.com
- **First publish**: `26.5.0`, run [29500238292](https://github.com/aspose-3d-foss/Aspose.3D-FOSS-for-Java/actions/runs/29500238292), 2026-07-16

---

## Workflow Overview

The workflow (`.github/workflows/maven-central-release.yml`) has 3 jobs:

| Job | Trigger | Purpose |
|-----|---------|---------|
| `dry-run-ubuntu` | `workflow_dispatch -f target=ubuntu` | Pre-release validation on GitHub-hosted runner, no deploy |
| `dry-run-windows` | `workflow_dispatch -f target=windows` | Validation on self-hosted Windows runner, no deploy |
| `release-deploy` | Push of a tag matching `v*` or `V*` | Full sign + deploy to Central Portal |

**Deploy ONLY fires on a tag push** — `workflow_dispatch` never deploys. The workflow
creates the GitHub Release itself (`gh release create ... --generate-notes --latest`) if
one doesn't already exist for the tag, so no manual Release step is required.

---

## Publishing a New Version

### Step 1: Update version in pom.xml
```xml
<version>26.X.0</version>  <!-- must match the commercial Aspose.3D release -->
```

### Step 2: Commit and push
```bash
git add pom.xml
git commit -m "chore(version): bump to 26.X.0"
git push origin main
```

### Step 3 (optional): Run a remote dry-run first
```bash
gh workflow run maven-central-release.yml --repo aspose-3d-foss/Aspose.3D-FOSS-for-Java -f target=ubuntu
gh run list --repo aspose-3d-foss/Aspose.3D-FOSS-for-Java --workflow maven-central-release.yml
```

### Step 4: Tag and push (triggers the actual deploy)
```bash
git tag v26.X.0
git push origin v26.X.0
```

### Step 5: Monitor the release-deploy job
```bash
gh run list --repo aspose-3d-foss/Aspose.3D-FOSS-for-Java --workflow maven-central-release.yml
gh run view <RUN_ID> --repo aspose-3d-foss/Aspose.3D-FOSS-for-Java
```

### Step 6: Confirm the artifact is live
```bash
curl -s -o /dev/null -w "%{http_code}\n" "https://repo1.maven.org/maven2/org/aspose/aspose-3d-foss/26.X.0/"
# 200 = live. Central sync after upload typically takes 30 min - 4 hours.
```
`autoPublish=true` is set in pom.xml (see Known Issues below), so no manual click in
Central Portal is required once validation passes.

---

## GitHub Secrets (must be set once per repo)

| Secret | Description |
|--------|-------------|
| `GPG_PRIVATE_KEY` | Armored private key for `E176D5CBCA1DCC62` |
| `GPG_PASSPHRASE` | Passphrase for the GPG key |
| `MAVEN_CENTRAL_USERNAME` | Sonatype Central Portal token username |
| `MAVEN_CENTRAL_PASSWORD` | Sonatype Central Portal token password |

Set from Git Bash (gpg is not on the Windows system PATH):
```bash
gpg --armor --export-secret-keys E176D5CBCA1DCC62 | gh secret set GPG_PRIVATE_KEY --repo aspose-3d-foss/Aspose.3D-FOSS-for-Java
gh secret set GPG_PASSPHRASE         --repo aspose-3d-foss/Aspose.3D-FOSS-for-Java
gh secret set MAVEN_CENTRAL_USERNAME --repo aspose-3d-foss/Aspose.3D-FOSS-for-Java
gh secret set MAVEN_CENTRAL_PASSWORD --repo aspose-3d-foss/Aspose.3D-FOSS-for-Java
```

In an agent/non-interactive session, never run `gpg --export-secret-keys` directly — it
opens a pinentry dialog that hangs forever. Read the key from the offline backup instead
and pipe it into `gh secret set`.

---

## Self-Hosted Runner (Windows, optional)

Only needed if you want a `dry-run-windows` pre-flight check. Location:
`C:\tools\actions-runner-cells-foss\` (shared runner machine across FOSS Java repos).

Start: `cd C:\tools\actions-runner-cells-foss && .\run.cmd`

The job hardcodes the labels `self-hosted, Windows, maven-pilot`. If re-registering to
point at this repo:
```powershell
$token = (gh api repos/aspose-3d-foss/Aspose.3D-FOSS-for-Java/actions/runners/registration-token --method POST -q .token)
.\config.cmd --url https://github.com/aspose-3d-foss/Aspose.3D-FOSS-for-Java --token $token --name 3d-foss-win --labels "self-hosted,Windows,maven-pilot" --work _work --replace
$token = $null
```
Re-registering moves the runner off whatever repo it was previously serving — fine for
sequential single-repo work, not for running two Windows dry-runs at once.

---

## What Changed in This Repo for Maven Central

Commit [`718fecf`](https://github.com/aspose-3d-foss/Aspose.3D-FOSS-for-Java/commit/718fecf) ("ci: add Maven Central automated publishing workflow") added:

- `pom.xml` — `groupId`/`artifactId`/`version` coordinates, project metadata (name,
  description, url, licenses, developers, scm), and 4 build plugins:
  `maven-source-plugin`, `maven-javadoc-plugin` (output redirected to
  `target/apidocs`, not `docs/apidocs`), `maven-gpg-plugin`, and
  `central-publishing-maven-plugin`
- `.github/workflows/maven-central-release.yml` — the 3-job workflow described above
- `.gitignore` — excludes `target/`, `*.asc`, and other build/signing artifacts

No application source code was changed to support publishing. The first publish attempt
took 3 workflow dispatches to go green (`29499826665` and `29500015168` failed, fixed by
follow-up commit `85948b4` removing a UTF-8 BOM from Java source files that broke
`javac` on the Linux runner — see Known Issues below).

---

## Known Issues and Fixes

### `waitUtil` vs `waitUntil` typo in pom.xml
The live `pom.xml` in this repo has `<waitUtil>validated</waitUtil>` inside the
`central-publishing-maven-plugin` configuration block. The correct parameter name is
`waitUntil` (camelCase, no abbreviation). The plugin silently ignores unrecognized XML
elements, so this typo does **not** break publishing — `autoPublish=true` still uploads
and publishes correctly — but it does mean the Maven build does **not** block to confirm
portal validation before exiting. A portal-side rejection (e.g. missing metadata) would
show as a green CI run with the artifact stuck in "Pending Validation" rather than as a
build failure. Fix by correcting the element name next time `pom.xml` is touched:
```xml
<waitUntil>validated</waitUntil>
```

### `<developers>` block is not the canonical Aspose FOSS form
The live `pom.xml` has:
```xml
<developers>
  <developer>
    <name>Aspose</name>
    <organizationUrl>https://www.aspose.org</organizationUrl>
  </developer>
</developers>
```
The canonical block used across newer Aspose FOSS Java publications is:
```xml
<developers>
  <developer>
    <name>Aspose</name>
    <organization>Aspose Pty Ltd</organization>
    <organizationUrl>https://www.aspose.com/</organizationUrl>
  </developer>
</developers>
```
This repo is missing `<organization>` and still points `organizationUrl` at the old
`aspose.org` domain instead of `aspose.com`. Not fixed here — pom.xml is intentionally
left untouched by this documentation commit (Maven Central metadata for an already-
published version is not something to edit casually). **Product team action**: align
this block the next time a version bump touches `pom.xml` anyway.

### UTF-8 BOM in PowerShell-written files
The root cause of the two failed first-publish attempts. `Set-Content -Encoding UTF8` in
PowerShell adds a UTF-8 BOM (bytes `0xEF 0xBB 0xBF`), which `javac` rejects on Linux
runners. Fixed for the existing source tree by commit `85948b4`. For any future
PowerShell-driven file write in this repo, use:
```powershell
[System.IO.File]::WriteAllText($path, $content, [System.Text.UTF8Encoding]::new($false))
```

### mvn help:evaluate fails on the Windows runner
`actions/setup-java` with `server-id: central` + `central-publishing-maven-plugin` as an
extension causes `LifecyclePhaseNotFoundException` for `mvn help:evaluate` on the
self-hosted Windows job. The workflow uses PowerShell XML parsing instead:
```powershell
[xml]$pom = Get-Content pom.xml
$VER = $pom.project.version
```

### PowerShell em dash encoding
An em dash (`—`) in a double-quoted PowerShell string breaks PS 5.1 (byte `0x94` reads as
a smart quote in Windows-1252, terminating the string early). Use `--` instead of `—`.

### git grep exit code
`git grep` exits 1 when it finds no matches. The secret-scan steps rely on `|| true` (bash)
or an explicit `exit 0` (PowerShell) after a clean scan so the step doesn't fail spuriously.

### Release tag case
Both `V26.5.0` and `v26.5.0` are accepted — the workflow strips the `v`/`V` prefix before
comparing the tag to the pom.xml version.
