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
					"--glob", "!src_modded/*",
				},
    })
end, { noremap = true, silent = true })

vim.keymap.set('n', '<leader>fJ', function()
    builtin.find_files({
        hidden = true,
        no_ignore = true,
        no_ignore_parent = true,
				find_command = { 
					"rg",
					"--files",
					"--glob", "*.java",
					"--glob", "!src_original/*",
					"--glob", "!src/*",
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
								"--glob", "!src_modded/*",
            }
        end,
    })
end, { noremap = true, silent = true })

--custom dap config
require('dap').configurations.java = {
	{
    type = 'java',
    request = 'launch',
    name = 'b173-mods',
		projectName = function()
			return (io.open('settings.gradle'):read('*a') or ''):match("rootProject%.name%s*=%s*['\"]([%w-]+)['\"]") or ''
		end,
		mainClass = function()
			return (io.open('build.gradle'):read('*a') or ''):match("mainClass%s*=%s*['\"]([%w%.]+)['\"]") or ''
		end,
		classPaths = {'build/classes/java/main;build/resources/main;../libraries/com/paulscode/codecjorbis/20230120/codecjorbis-20230120-sources.jar;../libraries/com/paulscode/codecjorbis/20230120/codecjorbis-20230120.jar;../libraries/com/paulscode/codecwav/20101023/codecwav-20101023-sources.jar;../libraries/com/paulscode/codecwav/20101023/codecwav-20101023.jar;../libraries/com/paulscode/libraryjavasound/20101123/libraryjavasound-20101123.jar;../libraries/com/paulscode/librarylwjglopenal/20100824/librarylwjglopenal-20100824-sources.jar;../libraries/com/paulscode/librarylwjglopenal/20100824/librarylwjglopenal-20100824.jar;../libraries/com/paulscode/soundsystem/20120107/soundsystem-20120107-sources.jar;../libraries/com/paulscode/soundsystem/20120107/soundsystem-20120107.jar;../libraries/net/java/jinput/jinput/2.0.5/jinput-2.0.5-sources.jar;../libraries/net/java/jinput/jinput/2.0.5/jinput-2.0.5.jar;../libraries/net/java/jinput/jinput-platform/2.0.5/jinput-platform-2.0.5-natives-windows.jar;../libraries/net/java/jutils/jutils/1.0.0/jutils-1.0.0-sources.jar;../libraries/net/java/jutils/jutils/1.0.0/jutils-1.0.0.jar;../libraries/org/json/json/20230311/json-20230311-sources.jar;../libraries/org/json/json/20230311/json-20230311.jar;../libraries/org/lwjgl/lwjgl/lwjgl/2.9.4/lwjgl-2.9.4-sources.jar;../libraries/org/lwjgl/lwjgl/lwjgl/2.9.4/lwjgl-2.9.4.jar;../libraries/org/lwjgl/lwjgl/lwjgl-platform/2.9.3/lwjgl-platform-2.9.3-natives-windows.jar;../libraries/org/lwjgl/lwjgl/lwjgl_util/2.9.4/lwjgl_util-2.9.4-sources.jar;../libraries/org/lwjgl/lwjgl/lwjgl_util/2.9.4/lwjgl_util-2.9.4.jar;../libraries/org/mcphackers/launchwrapper/1.0/launchwrapper-1.0-sources.jar;../libraries/org/mcphackers/launchwrapper/1.0/launchwrapper-1.0.jar;../libraries/org/mcphackers/rdi/rdi/1.0/rdi-1.0-sources.jar;../libraries/org/mcphackers/rdi/rdi/1.0/rdi-1.0.jar;../libraries/org/ow2/asm/asm/9.2/asm-9.2-sources.jar;../libraries/org/ow2/asm/asm/9.2/asm-9.2.jar;../libraries/org/ow2/asm/asm-tree/9.2/asm-tree-9.2-sources.jar;../libraries/org/ow2/asm/asm-tree/9.2/asm-tree-9.2.jar;jars/deobfuscated.jar'},
		vmArgs = '-Djava.library.path=../libraries/natives',
		args = '--username Notch --session - --gameDir ../.minecraft/game --assetsDir ../.minecraft/game/assets --resourcesProxyPort 11705 --skinProxy pre-b1.9-pre4'
  }
}
