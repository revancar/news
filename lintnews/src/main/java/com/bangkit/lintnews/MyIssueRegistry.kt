package com.bangkit.lintnews

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

@Suppress("UnstableApiUsage")
class MyIssueRegistry: IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(NamingPatternDetactor.ISSUE_NAMING_PATTERN)

    override val api = CURRENT_API
}