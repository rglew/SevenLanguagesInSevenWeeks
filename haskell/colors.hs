let colors = ["red", "green", "blue"]
[(alabama, mississippi, georgia, tennessee, florida) | alabama <- colors, mississippi <- colors, georgia <- colors, tennessee <- colors, florida <- colors, mississippi /= tennessee, mississippi /= alabama, alabama /= tennessee, alabama /= georgia, alabama /= florida, georgia /= florida,  georgia /= tennessee]

