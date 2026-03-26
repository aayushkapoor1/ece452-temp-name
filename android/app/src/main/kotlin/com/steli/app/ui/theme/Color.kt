package com.steli.app.ui.theme

import androidx.compose.ui.graphics.Color

// ── Steli palette (light) ─────────────────────────────────────────
// Per requirement: only neutral colors (white/black) globally.
// Score colors are handled locally (green/yellow/red) in the UI.
val SteliLavenderBg = Color(0xFFFFFFFF)   // global page background (no tint)
val SteliSurface = Color(0xFFFFFFFF)      // cards/containers
val SteliSurfaceVariant = Color(0xFFFFFFFF)

val SteliInk = Color(0xFF111111)          // primary text / primary button
val SteliInkMuted = Color(0xFF6B6B6B)     // secondary text (neutral gray)
val SteliOutline = Color(0xFF111111)      // neutral outline

// Not used for core UI; keep neutral to avoid purple cast.
val SteliAccent = SteliInkMuted
