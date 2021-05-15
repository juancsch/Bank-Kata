module.exports = {
	verbose: true,
	transform: {
		'^.+\\.ts?$': 'ts-jest'
	},
	moduleFileExtensions: ['ts', 'js'],
	testMatch: ['<rootDir>/test/**/*.spec.ts'],
	testEnvironment: 'node',
	reporters: [ 'default' ]
}
