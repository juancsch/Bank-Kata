module.exports = {
	verbose: true,
	transform: {
		'^.+\\.ts?$': 'ts-jest'
	},
	moduleFileExtensions: ['ts', 'js'],
	testMatch: ['<rootDir>/test/**/*.spec.ts', '<rootDir>/test/*.e2e.ts'],
	testEnvironment: 'node',
	reporters: [ 'default' ]
}
