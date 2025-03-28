-- show source files despite being ignored
local builtin = require('telescope.builtin')
vim.keymap.set('n', '<leader>fj', function()
    builtin.find_files({
        hidden = true,
        no_ignore = true,
        no_ignore_parent = true,
				find_command = { 
					"rg",
					"--files",
					"--glob", "*.java",
					"--glob", "!src_original/*",
				},
    })
end, { noremap = true, silent = true })

-- for grep
vim.keymap.set('n', '<leader>fg', function()
    builtin.live_grep({
        additional_args = function()
            return {
                "--hidden",
                "--no-ignore",
                "--no-ignore-parent",
                "--glob", "*.java",
                "--glob", "!src_original/*",
            }
        end,
    })
end, { noremap = true, silent = true })

