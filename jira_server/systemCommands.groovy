def standardOutput = new StringBuilder()
def standardError = new StringBuilder()
def command = "mpc toggle"
def process = command.execute()

process.consumeProcessOutput(standardOutput, standardError)
return standardOutput
